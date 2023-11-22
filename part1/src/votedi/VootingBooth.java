package part1.src.votedi;

import java.util.HashMap;
import java.util.Map;

// DIP code, but still need to instantiate in main()

class Candidate {};

interface VoteRecorder {
    public void record(Candidate candidate);
}

public class VotingBooth {
    VoteRecorder recorder;

    public void setVoteRecorder(VoteRecorder recorder) {
        this.recorder = recorder;
    }

    public void vote(Candidate candidate) {
        recorder.record(candidate);
    }
}

class CountingVoteRecorder implements VoteRecorder {
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