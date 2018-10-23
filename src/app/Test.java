package app;

import methods.ScoreBoardControl;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ScoreBoardControl sbc = new ScoreBoardControl();
        sbc.MainLoop();
    }
}
