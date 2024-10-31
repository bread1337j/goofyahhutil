package Util; //Make sure to replace this with "import Util.*"

public class SampleTester {
    //Example of how to use JohnTests
    public static void main(String[] args) throws Exception{
        JohnTests Tester = new JohnTests(10); //define Tester
        Tester.queue(1, 2); //Expected output: 2, Received output: 1
        Tester.queue(true, "true"); //this will be marked as correct
        Tester.queue(Math.abs(-5), 5);
        Tester.queue("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbb");

        Tester.fire(0, false); //Will fire in default mode without wiping test cases
        Tester.fire(1, false); //Will show a Swing UI with the test without wiping test cases
        Tester.fire(2, true); //Will show every test case without abbreviating and wipe them.

    }
}
