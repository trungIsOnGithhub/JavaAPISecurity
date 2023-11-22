package part1.src.voterfi;

// non-DIP - RFI code

class Candidate {}

public class VotingBooth {
    VoteRecorder recorder = new VoteRecorder();

    public void vote(Candidate candidate) {
        recorder.record(candidate);
    }

    class VoteRecorder {
        Map hVotes = new HashMap();

        public void record(Candidate candidate) {
            int count = 0;

            if (!hVotes.containsKey(candidate)) {
                hVotes.put(candidate, count);
            } else {
                count = hVotes.get(candidate);
            }

            ++count;
            hVotes.put(candidate, count);
        }
    }
}