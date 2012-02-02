public class Driver {

    public Driver() {}

     public static void main(java.lang.String[] args) {
        // main method expects exactly one parameter.
        // usage: java Driver example:
        // java Driver /Users/srollins/Desktop/sampledir
        // Algorithm:
        //         1. create a FileBrowser
        //        2. invoke buildList method
        //         3. if buildList unsuccessful exit the program
        //        4. invoke viewDocs method
        if (args.length != 1) {
            System.out.println("Wrong number of args.");
            return;
        }
        String path = args[0];
       
        FileBrowser fb = new FileBrowser();
        if (!fb.buildList(path)) {
            System.out.println("buildList() Failed.");
            return;
        }
        fb.viewDocs();
     }
}