/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  GinormousInt.java
 *  Purpose       :  Creates methods for GinormousInt
 *  @author       :  Jason Wong
 *  Date written  :  2017-04-11
 *  Description   :  Methods for GinormousInt and doing mathematical calculations with great numbers
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  N/A
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-04-11  Jason Wong Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 public class GinormousInt{

  public static final GinormousInt ZERO = new GinormousInt("0");
  public static final GinormousInt ONE = new GinormousInt("1");
  public static final GinormousInt TEN = new GinormousInt("10");


   public String stringOfDigits;
   public String stringOfArray;

   private boolean signNegative;
   // private byte[] numArray;
  //  private byte[] addsum;
   public byte[] addholder;
   public byte[] numHolder;

   public GinormousInt(){
     this("0");
   }

   public GinormousInt(String inputValue){
     inputValue = inputValue.trim();
     if (inputValue.charAt(0)=='+'){
       signNegative = false;
       inputValue = inputValue.substring(1); // Begin storage after the operator sign
     }
     if (inputValue.charAt(0)=='-'){
       signNegative = true;
       inputValue = inputValue.substring(1); // Begin storage after the operator sign
     }
     this.numHolder = new byte[inputValue.length()];
     for (int i = 0; i<numHolder.length;i++){
       this.numHolder[this.numHolder.length - i - 1]  = Byte.parseByte(inputValue.substring(i,1+i));
     }
   }
  
  public GinormousInt multiply( GinormousInt numbertest ) {
        throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
     }

   // return valus of -1/0/1 = less than, equal to, greater than inputValue2
    public int compareTo(GinormousInt inputValue2){
        if (this.equals(inputValue2)){
        return 0;
      }
      if (!this.signNegative() && inputValue2.signNegative()){ // inputValue2 is negative, hence greater initial value
       return 1;
      }
      if (this.signNegative() && !inputValue2.signNegative()){ // inputValue2 is position, hence lesser initial value
        return -1;
      }
      if (!this.signNegative() && !inputValue2.signNegative()){
        if (inputValue2.numHolder.length < this.numHolder.length){
          return 1;
        }
     if(inputValue2.numHolder.length > this.numHolder.length){
       return -1;
     } }
     if (inputValue2.signNegative() && this.signNegative()){
       if (inputValue2.numHolder.length < this.numHolder.length){
         return -1;
       }
       if (inputValue2.numHolder.length > this.numHolder.length){
         return 1; // since the input value has a negative number with greater length, initial value larger.
     }
     if (inputValue2.numHolder.length == this.numHolder.length){
       for (int i = 0; i< this.numHolder.length; i++){
         if (inputValue2.numHolder[i] < this.numHolder[i]){
           return -1;
         }
     if (inputValue2.numHolder[i] > this.numHolder[i]){
       return 1;
       }
     }
   }
   }

   for (int i =0; i<this.numHolder.length; i++){
     if (inputValue2.numHolder[i] < this.numHolder[i]){
     return 1;
   }
   if (inputValue2.numHolder[i] > this.numHolder[i]){
     return -1;
   }
   }
     return -1;
   }

   public boolean signNegative(){
     return this.signNegative;
   }

   public boolean equals(GinormousInt inputValue2){
     return (this.toString().equals(inputValue2.toString()));
   }


public byte[] subtractByte(byte[] larger, byte[] smaller){ // later method used for subtraction
  byte[] subfin = new byte[larger.length + 1];
  subfin[larger.length] = 0;
  for (int i = 0; i < smaller.length; i++){
    subfin[i] += larger[i] - smaller[i];
    if (subfin[i] < 0){
      larger[i+1] -= 1;
      larger[i] +=10 ;
      larger[i] += larger[i] - smaller[i];
    }
  }
  for (int i = smaller.length; i<larger.length; i++){
  subfin[i] += larger[i];
  }
    return subfin;
}

public byte[] addByte(byte[] larger, byte[] smaller){ // addingbytes and later method used for addition
  byte[] addholder = new byte[larger.length];
  byte[] addsum = new byte[larger.length+1];

  for (int t = 0; t < smaller.length; t++){
    addholder[t] = smaller[t];
  }
  addsum[larger.length] = 0;
  for (int i=0; i<larger.length;i++){
    addsum[i] += larger[i] + addholder[i];
    if (addsum[i] >=10) {
      addsum[i] -= addsum[i] - 1;
      addsum[i + 1] = 1;
  }
}
return addsum;
}
  public String arraytoString(byte[] numHolder){
    stringOfArray = "";
    for (int i = numHolder.length -1; i>=0; i--){
      stringOfArray += numHolder[i];
    }
    return stringOfArray;
  }

   public String toString(){
     stringOfDigits = "";
     for (int i = numHolder.length -1; i>= 0; i--){
       stringOfDigits = stringOfDigits + numHolder[i];
     }
     if(!signNegative){
       stringOfDigits = '+' + stringOfDigits;
     }else if(signNegative){
       stringOfDigits = '-' + stringOfDigits;
     }
     return stringOfDigits;
   }

   public GinormousInt divide( GinormousInt numbertest ) {
        throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
     }

   public GinormousInt remainder( GinormousInt numbertest ) {
        throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
     }

 public GinormousInt subtract( GinormousInt value ){
   if(value.signNegative() && !this.signNegative()){
     GinormousInt ulti = new GinormousInt(value.toString().substring(1));
     return this.addInt(ulti);
   } else if (value.signNegative() && this.signNegative()) {
     GinormousInt ulti = new GinormousInt(value.toString().substring(1));
     if (this.compareTo(value) == 1){
      return new GinormousInt(arraytoString(this.subtractByte(value.numHolder, this.numHolder)));
     } else if (this.compareTo(value) == -1){
       return new GinormousInt("-" + arraytoString(this.subtractByte(this.numHolder, value.numHolder)));
  }else {
    return new GinormousInt("0");
  }
}
String subfin = "";
if (this.compareTo(value) == 1){
  subfin = arraytoString(subtractByte(this.numHolder, value.numHolder));
} else {
  subfin = arraytoString(subtractByte(value.numHolder, this.numHolder));
}
if (signNegative){
  subfin = "-" + subfin;
}
return new GinormousInt(subfin);
}

public GinormousInt addInt( GinormousInt value3 ){
  if(!value3.signNegative() && this.signNegative()){
    GinormousInt ulti = new GinormousInt(value3.toString().substring(1));
    if (ulti.compareTo(value3) == 1){
    String subfin = "-" + value3.subtract(ulti).toString().substring(1);
      return new GinormousInt(subfin);
    }else{
      return value3.subtract(ulti);
    }
} else if (!this.signNegative()&&value3.signNegative()){
  GinormousInt ulti = new GinormousInt(value3.toString().substring(1));
  if (ulti.compareTo(this)==1){
    String subfin = "-" + ulti.subtract(this).toString().substring(1);
    return new GinormousInt(subfin);

  }else {
    return this.subtract(ulti);
  }
}
String subfin = "";
if (this.compareTo(value3) ==1){
  subfin = arraytoString(addByte(this.numHolder, value3.numHolder));
} else {
  subfin = arraytoString(addByte(value3.numHolder, this.numHolder));
}
if (signNegative()){
  subfin = "-" + subfin;
}

return new GinormousInt(subfin);
}

public static void main( String[] args ) {
     System.out.println( "\n  Hello, world, from the GinormousInt program!!\n" );
     System.out.println( "\n   You should run your tests from the GinormousIntTester...\n" );

     System.exit( 0 );
  }
}

