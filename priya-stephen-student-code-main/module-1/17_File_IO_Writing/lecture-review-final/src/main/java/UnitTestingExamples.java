public class UnitTestingExamples {

    public boolean isEven(int number){
        boolean isEven = false;

        if(number == 0){
            isEven = true;
        } else if(number == 2){
            isEven = true;
        } else if(number == 4) {
            isEven = true;
        }

        // if number is 6, false will be returned

        return isEven;
    }

    /*
     * Given a non-empty string like "Code" return a string like "CCoCodCode".
     * stringSplosion("Code") → "CCoCodCode"        * "CCodCoCode" *
     * stringSplosion("abc") → "aababc"
     * stringSplosion("ab") → "aab"
     */
    public String stringSplosion(String str) {

        // Have to use substring to get portions of bigger string
        // .substring(firstIndex, lastIndex)

        // Code
        //    C            + Co              + Cod             + Code
        // substring(0, 1) + substring(0, 2) + substring(0, 3) + substring(0, 4)

        String stringExplosion = "";

        // Loop with loop variable 1 to 4
        for( int i = 1; i < str.length(); i++){

            stringExplosion += str.substring(0, i);

        }

        return stringExplosion;
    }

    /*
     Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed.
     The "yak" strings will not overlap.
     stringYak("yakpak") → "pak"
     stringYak("pakyak") → "pak"
     stringYak("yak123ya") → "123ya"
     */
    public String stringYak(String str) {

        String removedYak = str;
        String yakStringToFind = "yak";

        int startOfYakString = removedYak.indexOf("yak");

        while(startOfYakString != -1){

            String firstHalf = removedYak.substring(0, startOfYakString);
            String secondHalf = removedYak.substring(startOfYakString + yakStringToFind.length());

            removedYak = firstHalf + secondHalf;

            startOfYakString = removedYak.indexOf("yak");
        }

        return removedYak;
    }

}
