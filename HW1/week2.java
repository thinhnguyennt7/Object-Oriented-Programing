jShell process:

R ead
E val
P rint
L oop

command line: jshell

jshell> x = 1
|  Error:
|  cannot find symbol
|    symbol:   variable x
|  x = 1
|  ^

jshell>


jshell doesn't need the semicolon

jshell> int x
x ==> 0

default value of int, double. ... always  0


Loosy conversion:


Types: 
+ Primitive:
	- int(32), byte, short, long(64), char
	- double, float
	- boolean
+ Reference:
	- Object: Capitalize
	- String:
	- ....

* Null is only valueable for only Reference value not Primitive


Instance variable: 
jshel: 
double y
-> y = 0.0

convert to float
float y = 0.0f
-> y = 0.0 


jshell> 'a'
$2 ==> 'a'

jshell> 'a'+1
$3 ==> 98

jshell> "a" + 1
$4 ==> "a1"



jshell> String s
s ==> null

jshell> s = 1
|  Error:
|  incompatible types: int cannot be converted to java.lang.String
|  s = 1
|      ^

jshell> s = 1 + ""
s ==> "1"