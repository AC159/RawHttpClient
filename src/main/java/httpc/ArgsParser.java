package httpc;

public class ArgsParser {

    public boolean verbose;
    public String header;
    public String url;
    public String httpMethod;
    public String data;
    public String filePath;

    public ArgsParser(String[] args) {
        parse(args);
    }

    private void parse(String[] args) {

        // todo: improve the parsing strategy
        if (args.length == 0 || (args[0].equals("help") && args.length == 1)) {
            System.out.println("httpc.httpc is a curl-like application but supports HTTP protocol only.\n" +
                    "Usage:\n" +
                    "\thttpc.httpc command [arguments]\n" +
                    "The commands are:\n" +
                    "\tget \t executes a HTTP GET request and prints the response.\n" +
                    "\tpost \t executes a HTTP POST request and prints the response.\n" +
                    "\thelp \t prints this screen.\n" +
                    "Use \"httpc.httpc help [command]\" for more information about a command.");
            System.exit(0);
        } else if (args[1].equalsIgnoreCase("get") && args[0].equalsIgnoreCase("help")) {
            System.out.println("usage: httpc.httpc get [-v] [-h key:value] URL\n" +
                    "Get executes a HTTP GET request for a given URL.\n" +
                    "\t-v \t Prints the detail of the response such as protocol, status and headers.\n" +
                    "\t-h key:value \t Associates headers to HTTP Request with the format 'key:value'.\n");
            System.exit(0);
        } else if (args[1].equalsIgnoreCase("post") && args[0].equalsIgnoreCase("help")) {
            System.out.println("usage: httpc.httpc post [-v] [-h key:value] [-d inline-data] [-f file] URL\n" +
                    "Post executes a HTTP POST request for a given URL with inline data or from file.\n" +
                    "\t-v \t Prints the detail of the response such as protocol, status and headers.\n" +
                    "\t-h key:value \t Associates headers to HTTP Request with the format 'key:value'.\n" +
                    "\t-d string \t Associates an inline data to the body HTTP POST request.\n" +
                    "\t-f file \t Associates the content of a file to the body HTTP POST request.");
            System.exit(0);
        }

        // Extract method and url
        httpMethod = args[0];
        url = args[args.length-1];

//        for (int i = 2; i < args.length; i++) {
//            String arg = args[i];
//            if (arg.equals("-v")) verbose = true;
//        }

    }

}
