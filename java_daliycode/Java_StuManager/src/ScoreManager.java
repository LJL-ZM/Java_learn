import java.util.Arrays;

public class ScoreManager {
    public static final int NPOS = -1;
    private static final int DEFAULT_SIZE = 35;
    private int size;
    private Score[] scores = new Score[DEFAULT_SIZE];

    ScoreManager(){}

    public int find(String name, int courseId){
        for(int i = 0; i < size; i++){
            if(name.equals(scores[i].getName()) && courseId == scores[i].getCourseId()){
                return i;
            }
        }
        return NPOS;
    }

    public boolean add(Score score){
        String name = score.getName();
        int courseId = score.getCourseId();
        int pos = find(name, courseId);
        if(pos != NPOS){
            return false;
        }
        if(size == scores.length){
            scores = Arrays.copyOf(scores, scores.length + 5);
        }
        scores[size++] = score;
        return true;
    }

    public boolean erase(String name, int courseId){
        int pos = find(name, courseId);
        if(pos == NPOS){
            return false;
        }
        for(int i = pos; i < --size; i++){
            scores[i] = scores[i + 1];
        }
        return true;
    }

    public boolean modify(Score score){
        String name = score.getName();
        int courseId = score.getCourseId();
        int pos = find(name, courseId);
        if(pos == NPOS){
            return false;
        }
        scores[pos] = score;
        return true;
    }

    public int getSize() {
        return size;
    }

    public Score getPos(int pos){
        return scores[pos];
    }
}