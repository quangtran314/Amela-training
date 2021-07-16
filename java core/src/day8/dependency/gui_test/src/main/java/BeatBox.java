import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.sound.midi.*;

public class BeatBox{
    private JPanel mainPanel;
    private ArrayList<JCheckBox> checkBoxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private static Font font = new Font("senserif", Font.BOLD, 18);

    private String[] instrumentName = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acounstic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args){
        BeatBox beatBox = new BeatBox();
        beatBox.buildGui();
    }

    public void buildGui(){
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel backGround = new JPanel(layout);
        backGround.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new MyStartListener());
        buttonBox.add(startButton);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new MyStopListener());
        buttonBox.add(stopButton);

        JButton tempoUp = new JButton("Tempo Up");
        tempoUp.addActionListener(new MyUpTempoListener());
        buttonBox.add(tempoUp);

        JButton tempoDown = new JButton("Tempo Down");
        tempoDown.addActionListener(new MyDownTempoListener());
        buttonBox.add(tempoDown);

        JButton reset = new JButton("Reset");
        reset.addActionListener(new MyResetListener());
        buttonBox.add(reset);

        JButton serializelt = new JButton("serializelt");
        serializelt.addActionListener(new MySendListener());
        buttonBox.add(serializelt);

        JButton restore = new JButton("restore");
        restore.addActionListener(new MyReadInListener());
        buttonBox.add(restore);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for(int i = 0; i < instrumentName.length; i++){
            JLabel label = new JLabel(instrumentName[i]);
            label.setIconTextGap(10);
            nameBox.add(label);
        }

        backGround.add(BorderLayout.EAST, buttonBox);
        backGround.add(BorderLayout.WEST, nameBox);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        checkBoxList = new ArrayList<JCheckBox>();

        for(int i = 0; i < 256; i++){
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(false);
            checkBox.setSize(18, 18);
            checkBoxList.add(checkBox);
            mainPanel.add(checkBox);
        }

        backGround.add(BorderLayout.CENTER, mainPanel);
        frame.getContentPane().add(backGround);

        setUpMidi();

        frame.setBounds(50, 50, 500, 500);
        frame.pack();
        frame.setVisible(true);
    }

    class MyStartListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            buildTrackAndStart();
        }
    }

    class MyStopListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            sequencer.stop();
        }
    }

    class MyUpTempoListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }
    }

    class MyDownTempoListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * .97));
        }
    }

    class MyResetListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            for(JCheckBox box : checkBoxList){
                box.setSelected(false);
            }
        }
    }

    class MyReadInListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            boolean[] checkBoxState = null;
            try{
                FileInputStream fileInput = new FileInputStream("checkBox.ser");
                ObjectInputStream input = new ObjectInputStream(fileInput);
                checkBoxState = (boolean[]) input.readObject();
                input.close();
            }catch(Exception e){
                e.getStackTrace();
            }

            for(int i = 0; i < 256; i++){
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if(checkBoxState[i]){
                    check.setSelected(true);
                }else{
                    check.setSelected(false);
                }
            }

            sequencer.stop();
            buildTrackAndStart();
        }
    }

    class MySendListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            boolean[] checkBoxState = new boolean[256];
            for(int i = 0; i < 256; i++){
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if(check.isSelected()){
                    checkBoxState[i] = true;
                }
            }

            try{
                FileOutputStream fileOutput = new FileOutputStream("checkBox.ser");
                ObjectOutputStream output = new ObjectOutputStream(fileOutput);
                output.writeObject(checkBoxState);
                output.close();
            }catch(IOException e){
                e.getStackTrace();
            }
        }
    }

    private void setUpMidi() {
        try{
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart(){
        int[] trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for(int i = 0; i < 16; i++){
            trackList = new int[16];

            int key = instruments[i];

            for(int j = 0; j < 16; j++){
                JCheckBox jc = (JCheckBox) checkBoxList.get(j + 16 * i);
                if(jc.isSelected()){
                    trackList[j] = key;
                }else{
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0, 15));
        try{
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        }catch(Exception e){
            e.getStackTrace();
        }
    }

    private void makeTracks(int[] list) {
        for(int i = 0; i < 16; i++){
            int key = list[i];

            if(key != 0){
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent(int comp, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try{
            ShortMessage message = new ShortMessage();
            message.setMessage(comp, chan, one, two);
            event = new MidiEvent(message, tick);
        }catch (Exception e){
            e.getStackTrace();
        }
        return event;
    }
}
