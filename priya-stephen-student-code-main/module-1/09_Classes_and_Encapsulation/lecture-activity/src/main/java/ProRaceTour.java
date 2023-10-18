import java.util.ArrayList;
import java.util.List;

/*
 * This class contains a list of racetracks and has the
 * ability to start a race on a racetrack
 */
public class ProRaceTour {
    private List<Racetrack> proTourRacetracks;

    public ProRaceTour(){
        proTourRacetracks = new ArrayList<>();
    }

    public void addRacetrackToTheTour(Racetrack newRacetrack){
        proTourRacetracks.add(newRacetrack);
    }

    public void startRace(String raceName){

        for( Racetrack track : this.proTourRacetracks ){

            if (track.getRacetrackName().equalsIgnoreCase(raceName) ){
                track.startRace();
                break;
            }
        }
    }
}
