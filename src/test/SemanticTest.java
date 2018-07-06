package test;

import main.SprilGenerator;
import org.junit.Test;

import java.io.File;

public class SemanticTest {

    private final static String DIR = "/Users/ducu97/IntelliJProjects/FinalProject/src/test/sample_progs/";

    /**
     * Class that generates the code for each program sample we've made.
     * This is supposed to be run one by one and the output file,
     * which appears in the root folder of the project and is named
     * "myProgram.hs", must be loaded into Sprockell.
     *
     * The intended results are commented above each test
     **/


    @Test // 450
    public void generateProgram1() {
        new SprilGenerator().generate(new File(DIR + "program1.txt").toPath());
    }

    @Test // 1 1 0 1 1 0
    public void generateProgram2() {
        new SprilGenerator().generate(new File(DIR + "program2.txt").toPath());
    }

    @Test // 5
    public void generateProgram3() {
        new SprilGenerator().generate(new File(DIR + "program3.txt").toPath());
    }

    @Test // 7 23
    public void generateProgram4() {
        new SprilGenerator().generate(new File(DIR + "program4.txt").toPath());
    }

    @Test // 23
    public void generateProgram5() {
        new SprilGenerator().generate(new File(DIR + "program5.txt").toPath());
    }

    @Test // 0 0
    public void generateProgram6() {
        new SprilGenerator().generate(new File(DIR + "program6.txt").toPath());
    }

    @Test // 5
    public void generateProgram7() {
        new SprilGenerator().generate(new File(DIR + "program7.txt").toPath());
    }

    @Test // 4
    public void generateProgram8() {
        new SprilGenerator().generate(new File(DIR + "program8.txt").toPath());
    }

    @Test // 6 100
    public void generateProgram9() {
        new SprilGenerator().generate(new File(DIR + "program9.txt").toPath());
    }

    @Test // 5 5 1
    public void generateProgram10() {
        new SprilGenerator().generate(new File(DIR + "program10.txt").toPath());
    }

    @Test // 28
    public void generateProgram11() {
        new SprilGenerator().generate(new File(DIR + "program11.txt").toPath());
    }

    @Test // 1 --true
    public void generateProgram12() {
        new SprilGenerator().generate(new File(DIR + "program12.txt").toPath());
    }

    @Test // 5
    public void generateProgram13() {
        new SprilGenerator().generate(new File(DIR + "program13.txt").toPath());
    }

    @Test // 8
    public void generatePetersonsAlgorithm() {
        new SprilGenerator().generate(new File(DIR + "petersons_algorithm.txt").toPath());
    }

    @Test // 500
    public void generateBankingSystem() {
        new SprilGenerator().generate(new File(DIR + "banking_program.txt").toPath());
    }

}
