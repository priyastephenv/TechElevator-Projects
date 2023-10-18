public class RacingApp {

    public static void main(String[] args) {
        /*
         * Create a pro race tour
         */
        ProRaceTour raceTour = new ProRaceTour();

        /*
         * Create a new racetrack
         */
            Racetrack track = new Racetrack("SuperLawn 500");

        /*
         * Create competitors for the racetrack
         */
        String imageUrl = "https://raw.githubusercontent.com/dencee/method-climber/main/assets/images/polly-programmer.png";
        Competitor polly = new Competitor(imageUrl, 1);

        //String imageUrl = "https://raw.githubusercontent.com/dencee/method-climber/main/assets/images/polly-programmer.png";
        //String imageUrl = "https://www.pngfind.com/pngs/m/55-556567_sacks-of-potatoes-potato-bag-png-transparent-png.png";

            Competitor potatoes = new Competitor(imageUrl, 2);
            track.addCompetitor(potatoes);
        /*
         * Add the racetrack to the pro tour!
         */
            raceTour.addRacetrackToTheTour(track);
        /*
         * Start a race!
         *
         */

        raceTour.startRace("Super Lawn 500");

    }
}
