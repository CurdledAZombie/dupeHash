# dupeHash
# Version hash challenge in java

* iterates all possible versions in order where version is defined as x.x.x-SNAPSHOT  
* x's are integers from 0-99 (except for the leftmost x which is 0-infinity)  
* -SNAPSHOT is a string that is either there or not  
  * the first version is 0.0.0-SNAPSHOT  
  * the second version is 0.0.0  
  * the third version is 0.0.1-SNAPSHOT  
  * the fourth version is 0.0.1  
  * more versions......  
  * 0.1.1-SNAPSHOT  
  * 0.1.1  
  * .........  
  * 1.2.99  
  * 1.3.0-SNAPSHOT  
* convert each version to a string if it isn't one already
* sha256 the string version
* take the first 8 bytes
* base64 encode the bytes
* find the first version starting from 0.0.0-SNAPSHOT in order that is a duplicate of another version
