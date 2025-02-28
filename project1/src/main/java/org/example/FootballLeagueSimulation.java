import java.util.ArrayList; // for arrays
import java.util.Collections; // for sorting
import java.util.HashMap; // key value like dictionary
import java.util.Map;  // for mapping
import java.util.Random; // for random numbers
import java.util.Scanner; // for interface

class Player {
    String name;
    Position position; // enum shortcut

    // goalkeeper attributes
    int aerialReach;
    int commandOfArea;
    int communication;
    int eccentricity;
    int firstTouch;
    int handling;
    int kicking;
    int oneOnOnes;
    int passing;
    int punchingTendency;
    int reflexes;
    int rushingOutTendency;
    int throwing;

    // mental attributes
    int aggression;
    int anticipation;
    int bravery;
    int composure;
    int concentration;
    int decisions;
    int determination;
    int positioning;
    int teamwork;
    int workRate;

    // technical attributes
    int vision;
    int leadership;
    int flair;
    int offTheBall;
    int technique;

    // physical attributes
    int acceleration;
    int agility;
    int balance;
    int jumpingReach;
    int naturalFitness;
    int pace;
    int stamina;
    int strength;
    int freeKickTaking;
    int penaltyTaking;

    float averageSkill;

    public Player(String name, Position position) { // construct method , creates player object
        this.name = name;
        this.position = position;
        generateAttributes();
        this.averageSkill = calculateAverageSkill();
    }

    private void generateAttributes() { // random value for player attribute
        Random rand = new Random();

        // Goalkeeper Attributes
        this.aerialReach = rand.nextInt(20) + 1;
        this.commandOfArea = rand.nextInt(20) + 1;
        this.communication = rand.nextInt(20) + 1;
        this.eccentricity = rand.nextInt(20) + 1;
        this.firstTouch = rand.nextInt(20) + 1;
        this.handling = rand.nextInt(20) + 1;
        this.kicking = rand.nextInt(20) + 1;
        this.oneOnOnes = rand.nextInt(20) + 1;
        this.passing = rand.nextInt(20) + 1;
        this.punchingTendency = rand.nextInt(20) + 1;
        this.reflexes = rand.nextInt(20) + 1;
        this.rushingOutTendency = rand.nextInt(20) + 1;
        this.throwing = rand.nextInt(20) + 1;

        // Mental Attributes
        this.aggression = rand.nextInt(20) + 1;
        this.anticipation = rand.nextInt(20) + 1;
        this.bravery = rand.nextInt(20) + 1;
        this.composure = rand.nextInt(20) + 1;
        this.concentration = rand.nextInt(20) + 1;
        this.decisions = rand.nextInt(20) + 1;
        this.determination = rand.nextInt(20) + 1;
        this.positioning = rand.nextInt(20) + 1;
        this.teamwork = rand.nextInt(20) + 1;
        this.workRate = rand.nextInt(20) + 1;

        // Technical Attributes
        this.vision = rand.nextInt(20) + 1;
        this.leadership = rand.nextInt(20) + 1;
        this.flair = rand.nextInt(20) + 1;
        this.offTheBall = rand.nextInt(20) + 1;
        this.technique = rand.nextInt(20) + 1;

        // Physical Attributes
        this.acceleration = rand.nextInt(20) + 1;
        this.agility = rand.nextInt(20) + 1;
        this.balance = rand.nextInt(20) + 1;
        this.jumpingReach = rand.nextInt(20) + 1;
        this.naturalFitness = rand.nextInt(20) + 1;
        this.pace = rand.nextInt(20) + 1;
        this.stamina = rand.nextInt(20) + 1;
        this.strength = rand.nextInt(20) + 1;
        this.freeKickTaking = rand.nextInt(20) + 1;
        this.penaltyTaking = rand.nextInt(20) + 1;
    }

    private float calculateAverageSkill() {
        float totalSkill = 0;
        int count = 0;

        switch (position) {
            case GOALKEEPER:
                totalSkill = 1.0f * (aerialReach + commandOfArea + communication + eccentricity + firstTouch +
                        handling + kicking + oneOnOnes + passing + punchingTendency + reflexes +
                        rushingOutTendency + throwing) +
                        0.2f * (aggression + anticipation + bravery + composure + concentration + decisions +
                                determination + positioning + teamwork + workRate + vision + leadership + flair +
                                offTheBall + technique + acceleration + agility + balance + jumpingReach +
                                naturalFitness + pace + stamina + strength + freeKickTaking + penaltyTaking);
                count = 13 + 25; // 13 primary, 25 secondary, total 38
                break;
            case DEFENDER:
                totalSkill = 1.0f * (aggression + anticipation + bravery + composure + concentration + decisions +
                        determination + positioning + teamwork + workRate) +
                        0.2f * (vision + leadership + flair + offTheBall +
                                technique + acceleration + agility + balance + jumpingReach + naturalFitness +
                                pace + stamina + strength + freeKickTaking + penaltyTaking);
                count = 10 + 15; // 10 primary, 15 secondary, total 25 - 13 goalkeeper
                break;
            case MIDFIELDER:
                totalSkill = 1.0f * (vision + leadership + flair + offTheBall + technique) +
                        0.2f * (aggression + anticipation + bravery + composure +
                                concentration + decisions + determination + positioning + teamwork + workRate +
                                acceleration + agility + balance + jumpingReach + naturalFitness + pace +
                                stamina + strength + freeKickTaking + penaltyTaking);
                count = 5 + 20; // 5 primary, 20 secondary, total 25 - 13 goalkeeper
                break;
            case FORWARD:
                totalSkill = 1.0f * (acceleration + agility + balance + jumpingReach + naturalFitness + pace +
                        stamina + strength + freeKickTaking + penaltyTaking) +
                        0.2f * (aggression + anticipation + bravery + composure +
                                concentration + decisions + determination + positioning + teamwork + workRate +
                                vision + leadership + flair + offTheBall + technique);
                count = 10 + 15; // 10 primary, 15 secondary, total 25 - 13 goalkeeper
                break;
        }

        return totalSkill / (count * 1.0f); // to float
    }

    public void printPlayerDetails() {  // show player attribute.
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Average Skill: " + averageSkill);


        System.out.println("Goalkeeper Attributes:");
        System.out.println("Aerial Reach: " + aerialReach + ", Command of Area: " + commandOfArea +
                ", Communication: " + communication + ", Eccentricity: " + eccentricity +
                ", First Touch: " + firstTouch + ", Handling: " + handling +
                ", Kicking: " + kicking + ", One on Ones: " + oneOnOnes +
                ", Passing: " + passing + ", Punching Tendency: " + punchingTendency +
                ", Reflexes: " + reflexes + ", Rushing Out Tendency: " + rushingOutTendency +
                ", Throwing: " + throwing);

        System.out.println("\nMental Attributes:");
        System.out.println("Aggression: " + aggression + ", Anticipation: " + anticipation +
                ", Bravery: " + bravery + ", Composure: " + composure +
                ", Concentration: " + concentration + ", Decisions: " + decisions +
                ", Determination: " + determination + ", Positioning: " + positioning +
                ", Teamwork: " + teamwork + ", Work Rate: " + workRate);

        System.out.println("\nTechnical Attributes:");
        System.out.println("Vision: " + vision + ", Leadership: " + leadership + ", Flair: " + flair +
                ", Off the Ball: " + offTheBall + ", Technique: " + technique);

        System.out.println("\nPhysical Attributes:");
        System.out.println("Acceleration: " + acceleration + ", Agility: " + agility +
                ", Balance: " + balance + ", Jumping Reach: " + jumpingReach +
                ", Natural Fitness: " + naturalFitness + ", Pace: " + pace +
                ", Stamina: " + stamina + ", Strength: " + strength +
                ", Free Kick Taking: " + freeKickTaking + ", Penalty Taking: " + penaltyTaking);
    }
}

enum Position {
    GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD
}

class Team {
    String name;
    ArrayList<Player> players = new ArrayList<>();
    float defenseStrength;
    float offenseStrength;
    float midfieldStrength;
    float goalkeepingStrength;
    int fanPower;
    float teamStrength;

    ArrayList<String> lastThreeMatches = new ArrayList<>(3);  // for form function, W or L or D

    public Team(String name) { // constructor method, creates team object
        this.name = name;
        generatePlayers();
        calculateTeamStrengths();
        generateFanPower();
    }

    private void generatePlayers() {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {  // 3 goalkeeper
            players.add(new Player("PlayerGK" + i, Position.GOALKEEPER));
        }
        for (int i = 0; i < 10; i++) {  // 10 defender
            players.add(new Player("PlayerDF" + i, Position.DEFENDER));
        }
        for (int i = 0; i < 6; i++) { // 6 midfielder
            players.add(new Player("PlayerMF" + i, Position.MIDFIELDER));
        }
        for (int i = 0; i < 6; i++) { // 6 forward
            players.add(new Player("PlayerFW" + i, Position.FORWARD));
        }
    }

    private void calculateTeamStrengths() {
        float totalDefense = 0, totalMidfield = 0, totalOffense = 0, totalGoalkeeping = 0;

        for (Player player : players) { // foreach loop
            switch (player.position) {
                case GOALKEEPER:
                    totalGoalkeeping += player.averageSkill;
                    break;
                case DEFENDER:
                    totalDefense += player.averageSkill;
                    break;
                case MIDFIELDER:
                    totalMidfield += player.averageSkill;
                    break;
                case FORWARD:
                    totalOffense += player.averageSkill;
                    break;
            }
        }

        this.defenseStrength = totalDefense / 10;
        this.midfieldStrength = totalMidfield / 6;
        this.offenseStrength = totalOffense / 6;
        this.goalkeepingStrength = totalGoalkeeping / 3;
        this.teamStrength = (defenseStrength + midfieldStrength + offenseStrength + goalkeepingStrength) / 4;
    }

    private void generateFanPower() {
        Random rand = new Random();
        this.fanPower = rand.nextInt(21); // Fan gücü 0 ile 20 arasında
    }

    public void addMatchResult(String result) { // form function
        if (lastThreeMatches.size() == 3) {
            lastThreeMatches.remove(0);
        }
        lastThreeMatches.add(result);
    }

    public int calculateFormModifier() {
        int formScore = 0;
        for (String result : lastThreeMatches) { // foreach loop
            switch (result) {
                case "W":
                    formScore += 2;
                    break;
                case "D":
                    formScore += 1;
                    break;
                case "L":
                    formScore -= 1;
                    break;
            }
        }
        return formScore;
    }

    public void printTeamDetails() {
        System.out.println("Team: " + name);
        System.out.println("Team Strength: " + teamStrength);
        System.out.println("Goalkeeping Strength: " + goalkeepingStrength);
        System.out.println("Defense Strength: " + defenseStrength);
        System.out.println("Midfield Strength: " + midfieldStrength);
        System.out.println("Offense Strength: " + offenseStrength);
        System.out.println("Fan Power: " + fanPower);
        System.out.println("Form Score: " + calculateFormModifier());
        System.out.println("\nPlayers:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).name + " - Position: " + players.get(i).position);
        }
    }

    public void printPlayerDetails(int playerIndex) {
        if (playerIndex >= 0 && playerIndex < players.size()) {
            players.get(playerIndex).printPlayerDetails();
        } else {
            System.out.println("Invalid player index.");
        }
    }

    public void printTeamStrengths() { // for menu 1
        System.out.printf("%s - Average Strength: %.2f, Defense: %.2f, Offense: %.2f, Midfield: %.2f, Goalkeeping: %.2f, Fan Power: %d\n",
                name, teamStrength, defenseStrength, offenseStrength, midfieldStrength, goalkeepingStrength, fanPower);
    }
}

class Match {
    Team homeTeam;
    Team awayTeam;
    int homeScore;
    int awayScore;
    int homeAttacks;
    int awayAttacks;
    int homeDangerousAttacks;
    int awayDangerousAttacks;

    public Match(Team homeTeam, Team awayTeam) { // constructor method, creates match
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        playMatch();
    }

    private void playMatch() {
        Random rand = new Random();

        float homeAdvantage = (homeTeam.fanPower / 20.0f) + (homeTeam.calculateFormModifier() / 10.0f) + 2;
        float awayAdvantage = (awayTeam.calculateFormModifier() / 10.0f);

        this.homeAttacks = calculateAttacks(homeTeam, awayTeam, homeAdvantage);
        this.awayAttacks = calculateAttacks(awayTeam, homeTeam, awayAdvantage);

        this.homeDangerousAttacks = calculateDangerousAttacks(homeAttacks, homeTeam.fanPower);
        this.awayDangerousAttacks = calculateDangerousAttacks(awayAttacks, awayTeam.fanPower);

        this.homeScore = calculateGoals(homeDangerousAttacks, awayTeam.goalkeepingStrength);
        this.awayScore = calculateGoals(awayDangerousAttacks, homeTeam.goalkeepingStrength);

        updateMatchResult();
    }

    private int calculateAttacks(Team attackingTeam, Team defendingTeam, float advantage) {
        return Math.round(
                (attackingTeam.offenseStrength * 0.4f) + (attackingTeam.midfieldStrength * 0.3f)
                        + (attackingTeam.defenseStrength * 0.2f)
                        - (defendingTeam.defenseStrength * 0.3f)
                        - (defendingTeam.midfieldStrength * 0.2f)
                        + advantage
        );
    }

    private int calculateDangerousAttacks(int attacks, int fanPower) { // net attacks depends on fan power
        return Math.round(attacks * (fanPower / 20.0f));
    }

    private int calculateGoals(int dangerousAttacks, float opponentGoalkeepingStrength) {
        Random rand = new Random();
        int goals = 0;
        for (int i = 0; i < dangerousAttacks; i++) {
            float chance = (rand.nextFloat() * 5) + 5;  // random between 5-10
            if (chance > (opponentGoalkeepingStrength * 0.8)) { // if larger than %80
                goals++;
            }
        }
        return goals;
    }

    private void updateMatchResult() { // form list update
        if (homeScore > awayScore) {
            homeTeam.addMatchResult("W");
            awayTeam.addMatchResult("L");
        } else if (awayScore > homeScore) {
            homeTeam.addMatchResult("L");
            awayTeam.addMatchResult("W");
        } else {
            homeTeam.addMatchResult("D");
            awayTeam.addMatchResult("D");
        }
    }

    public void printResult() {
        System.out.println(homeTeam.name + " " + homeScore + " - " + awayScore + " " + awayTeam.name);
        System.out.println("Home Team Attacks: " + homeAttacks + " | Away Team Attacks: " + awayAttacks);
        System.out.println("Home Dangerous Attacks: " + homeDangerousAttacks + " | Away Dangerous Attacks: " + awayDangerousAttacks);
    }
}

class League {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Match> fixtures = new ArrayList<>();
    Map<Team, Integer> pointsTable = new HashMap<>();
    Map<Team, Integer> goalsForTable = new HashMap<>(); //
    Map<Team, Integer> goalsAgainstTable = new HashMap<>(); //
    Map<Team, Integer> goalDifferenceTable = new HashMap<>(); //
    Map<Team, Integer> winsTable = new HashMap<>();

    public League(ArrayList<String> teamNames) { //constructor method, creates league
        for (String name : teamNames) { // foreach loop
            teams.add(new Team(name));
        }
        generateFixtures();
        initializeTables();
    }

    private void generateFixtures() {
        int numTeams = teams.size();
        int numWeeks = numTeams - 1;
        int matchesPerWeek = numTeams / 2;

        // first term fixture
        for (int week = 0; week < numWeeks; week++) {
            ArrayList<Match> weekMatches = new ArrayList<>();

            for (int i = 0; i < matchesPerWeek; i++) {
                Team homeTeam = teams.get(i);              // head of list
                Team awayTeam = teams.get(numTeams - 1 - i);  // end of list

                if (week % 2 == 0) {
                    weekMatches.add(new Match(homeTeam, awayTeam));
                } else {
                    weekMatches.add(new Match(awayTeam, homeTeam));
                }
            }

            fixtures.addAll(weekMatches);

            Team lastTeam = teams.remove(teams.size() - 1);
            teams.add(1, lastTeam); // changing teams
        }

        // second term fixture
        ArrayList<Match> secondHalf = new ArrayList<>();
        for (Match match : fixtures) {
            secondHalf.add(new Match(match.awayTeam, match.homeTeam));
        }
        fixtures.addAll(secondHalf);
    }

    private void initializeTables() {
        for (Team team : teams) {
            pointsTable.put(team, 0);
            goalsForTable.put(team, 0);
            goalsAgainstTable.put(team, 0);
            goalDifferenceTable.put(team, 0);
            winsTable.put(team, 0);
        }
    }

    public void printTeamList() {
        System.out.println("Teams in the League:");
        for (int i = 0; i < teams.size(); i++) {
            teams.get(i).printTeamStrengths();
        }
    }

    public Team getTeamByIndex(int index) {
        if (index >= 0 && index < teams.size()) {
            return teams.get(index);
        } else {
            return null;
        }
    }

    public void printFixtures() {
        System.out.println("League Fixtures:");
        int matchesPerWeek = teams.size() / 2;
        int week = 1;
        for (int i = 0; i < fixtures.size(); i += matchesPerWeek) {
            System.out.println("\nWeek " + week);
            for (int j = i; j < i + matchesPerWeek; j++) {
                System.out.println(fixtures.get(j).homeTeam.name + " vs " + fixtures.get(j).awayTeam.name);
            }
            week++;
        }
    }

    public void playLeague() {
        for (Match match : fixtures) {
            match.printResult();
            updateTables(match);
        }
        printStandings();
    }

    private void updateTables(Match match) {
        Team home = match.homeTeam;
        Team away = match.awayTeam;
        int homePoints = pointsTable.get(home);
        int awayPoints = pointsTable.get(away);
        int homeGoalsFor = goalsForTable.get(home);
        int awayGoalsFor = goalsForTable.get(away);
        int homeGoalsAgainst = goalsAgainstTable.get(home);
        int awayGoalsAgainst = goalsAgainstTable.get(away);
        int homeWins = winsTable.get(home);
        int awayWins = winsTable.get(away);

        homeGoalsFor += match.homeScore; // update goals
        awayGoalsFor += match.awayScore; // update goals

        homeGoalsAgainst += match.awayScore; // update goals
        awayGoalsAgainst += match.homeScore; // update goals

        int homeGoalDifference = homeGoalsFor - homeGoalsAgainst;
        int awayGoalDifference = awayGoalsFor - awayGoalsAgainst;

        goalDifferenceTable.put(home, homeGoalDifference);
        goalDifferenceTable.put(away, awayGoalDifference);

        if (match.homeScore > match.awayScore) {
            homePoints += 3;
            homeWins += 1;
        } else if (match.awayScore > match.homeScore) {
            awayPoints += 3;
            awayWins += 1;
        } else {
            homePoints += 1;
            awayPoints += 1;
        }
            // all updates
        pointsTable.put(home, homePoints);
        pointsTable.put(away, awayPoints);
        goalsForTable.put(home, homeGoalsFor);
        goalsForTable.put(away, awayGoalsFor);
        goalsAgainstTable.put(home, homeGoalsAgainst);
        goalsAgainstTable.put(away, awayGoalsAgainst);
        winsTable.put(home, homeWins);
        winsTable.put(away, awayWins);
    }

    private void printStandings() { //sort functions
        System.out.println("\nPuan Durumu:");
        teams.sort((t1, t2) -> {
            int pointsCompare = pointsTable.get(t2) - pointsTable.get(t1);
            if (pointsCompare != 0) return pointsCompare;

            int goalDifferenceCompare = goalDifferenceTable.get(t2) - goalDifferenceTable.get(t1);
            if (goalDifferenceCompare != 0) return goalDifferenceCompare;

            int goalsForCompare = goalsForTable.get(t2) - goalsForTable.get(t1);
            if (goalsForCompare != 0) return goalsForCompare;

            return winsTable.get(t2) - winsTable.get(t1);
        });

        for (Team team : teams) {
            System.out.println(team.name + " - Puan: " + pointsTable.get(team) + ", Av.: " + goalDifferenceTable.get(team) +
                    ", Atılan Goller: " + goalsForTable.get(team) + ", Galibiyetler: " + winsTable.get(team));
        }
    }

    public void playMatchesWeekByWeek() {
        int week = 1;
        int matchesPerWeek = teams.size() / 2;
        for (int i = 0; i < fixtures.size(); i += matchesPerWeek) {
            System.out.println("\nWeek " + week);
            for (int j = i; j < i + matchesPerWeek && j < fixtures.size(); j++) {
                fixtures.get(j).printResult();
                updateTables(fixtures.get(j));
            }
            printStandings();
            week++;
        }
    }
}

public class FootballLeagueSimulation {
    public static void main(String[] args) {
        ArrayList<String> teamNames = new ArrayList<>();
        teamNames.add("Galatasaray");
        teamNames.add("Fenerbahçe");
        teamNames.add("Beşiktaş");
        teamNames.add("Trabzonspor");
        teamNames.add("Başakşehir FK");
        teamNames.add("Sivasspor");
        teamNames.add("Konyaspor");
        teamNames.add("Alanyaspor");
        teamNames.add("Adana Demirspor");
        teamNames.add("Gaziantep FK");
        teamNames.add("Antalyaspor");
        teamNames.add("Kayserispor");
        teamNames.add("Göztepe");
        teamNames.add("Bursaspor");
        teamNames.add("Gençlerbirliği");
        teamNames.add("Çaykur Rizespor");
        teamNames.add("Ankaragücü");
        teamNames.add("Samsunspor");

        League league = new League(teamNames);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Show Team List");
            System.out.println("2. Select Team and Show Players");
            System.out.println("3. Show Fixtures");
            System.out.println("4. Show Week by Week Match Results and Standings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    league.printTeamList();
                    break;
                case 2:
                    league.printTeamList();
                    System.out.print("Select a team by number: ");
                    int teamIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    Team selectedTeam = league.getTeamByIndex(teamIndex);
                    if (selectedTeam != null) {
                        selectedTeam.printTeamDetails();
                        System.out.print("Select a player by number: ");
                        int playerIndex = scanner.nextInt() - 1;
                        selectedTeam.printPlayerDetails(playerIndex);
                    } else {
                        System.out.println("Invalid team selection.");
                    }
                    break;
                case 3:
                    league.printFixtures();
                    break;
                case 4:
                    league.playMatchesWeekByWeek();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
