package FrontEnd.FrontController;

class CommandException extends Exception {
   public CommandException() {
       super();
   } 
   
   public CommandException(String msg) {
       super(msg);
   } 
}
