import java.util.*;

public class MethodReference {
    public static void main(String[] args){
        new MethodReference();
    }

    public MethodReference() {
        // There are 4 types of method references
        
        /* ==============================================
           ===== static methods =========================
           ==============================================
            
            Used when you are writing a lambda that simply
            calls a static method in some class:

            (params to staticMethod) -> {
                return staticMethod(params to staticMethod);
            }
            Can be simplified as
            ContainingClass::staticMethod        
        */

        // StringConverter is defined at the bottom of this file. Check it out
        // lastLetter takes in one String as its parameter
        StringConverter<Character> s = StringConverter::lastLetter;

        // The above is converted to the below. See that below is a lambda
        // that correctly targets StringConverter<Character>

        StringConverter<Character> s1 = (String str) -> {
            return StringConverter.lastLetter(str);
        };

        System.out.printf("Method ref: %s. Lambda: %s.%n%n",
            s.convert("Hello"), s1.convert("Hello"));

        // foo takes in two ints for parameters
        StringConverter<Character> w = StringConverter::foo;
        
        // It is converted to the below. See that below is a lambda that doesn't
        // correctly target StringConverter<Character> because it takes in the
        // wrong parameters. The code below and above therefore don't compile
        
        StringConverter<Character> w1 = (int i1, int i2) -> {
            return StringConverter.foo(i1, i2);
        };





        /* ==============================================
           ===== arbitrary object non-static methods ====
           ==============================================
            
            Used when simply writing a lambda that calls
            some method on some arbitrary object

            (obj, params to method) -> {
                return obj.method(params to method);
            }
            Can be simplified as
            ContainingClass::method

            Note that the lambda takes in the object to call
            the method on and also the parameters for the method
        */
       
        // String's length method must be called on a String and has no
        // parameters
        StringConverter<Integer> s2 = String::length;

        // This is converted to the code below. See that it is a lambda that
        // correctly targets StringConverter
        
        StringConverter<Integer> s3 = (String obj) -> {
            return obj.length();
        };

        // String's charAt method takes in a single int parameter
        StringConverter<Character> w2 = String::charAt;

        // The above method reference is converted to the below lambda. See
        // that it doesn't properly target StringConverter<Inetger>. The code
        // above and below therfore doesn't compile
        
        StringConverter<Character> w3 = (String obj, int charIndex) -> {
            obj.charAt(charIndex);
        };
         
        System.out.printf("Method ref: %s. Lambda: %s.%n%n",
            s2.convert("Hello"), s3.convert("Hello"));

        /* ==============================================
           ===== specific object non-static methods =====
           ==============================================
            
            Used when a lambda simply calls a method on a
            specific object
            
            (params to method) -> {
                return obj.method(params to method);
            }
            Can be simplified as
            obj::method

            Note that obj is an object that exists already.
            The same object is used each time the lambda is
            used
        */
       
        // The object to use in this method reference
        String equalityString = "Hello";
        // String's equal method can take in a String
        StringConverter<Boolean> s4 = equalityString::equals;

        // The above method reference becomes the below lambda. See that the 
        // lambda below correctly targets StringConverter<Boolean>.
        
        StringConverter<Boolean> s5 = (String otherString) -> {
            // note that equalityString is the object of the method reference
            // Make sure you see how this is different from arbitrary object
            // method references
            return equalityString.equals(otherString);
        };

        // The object I'm using for this method reference
        Exception e = new Exception("Don't throw me");
        // // getMessage takes in no paramters
        StringConverter<String> w4 = e::getMessage;

        // // The above method reference becomes the below lambda. See that the
        // // below lambda doesn't properly target StringConverter<String> and
        // // therefore will not compile.
        
        StringConverter<String> w5 = () -> {
            return e.getMessage();
        };

        System.out.printf("Method ref: %s. Lambda: %s.%n%n",
            s4.convert("Hello"), s5.convert("Hello"));



        /* ==============================================
           ===== constructor ============================
           ==============================================
            
            Used when a lambda simply calls the constructor of some class

            (params to constructor) -> {
                return new Class(params to constructor);
            }
            Can be simplified as
            Class::new
        */
       
        // String builder has a constructor that takes in a String
        StringConverter<StringBuilder> s6 = StringBuilder::new;

        // The above method reference becomes the below lambda. See how the
        // lambda correctly target StringConverter<StringBuilder>
        
        StringConverter<StringBuilder> s7 = (String str) -> {
            return new StringBuilder(str);
        };

        // Object has a no-args constructor
        StringConverter<Object> w6 = Object::new;

        // The above Method reference is converted to the below lambda. See that
        // it doesn't correctly target StringConverter<Object> and therefore
        // won't compile
        
        StringConverter<Object> w7 = () -> {
            return new Object();
        };

        System.out.printf("Method ref: %s. Lambda: %s.%n%n",
            s6.convert("Hello"), s7.convert("Hello"));
    }

    // Functional Interface
    public interface StringConverter<R> {
        public R convert(String s);

        public static char lastLetter(String str) {
            return str.charAt(str.length() - 1);
        }

        public static char foo(int i, int j) {
            return (char) (i + j);
        }    
    } 
}