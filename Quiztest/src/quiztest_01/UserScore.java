package quiztest_01;

public class UserScore {
	private String id;
	private int score;
	private String tier;
	private int rank;
	public UserScore() {
		super();
	}
	public UserScore(String id, int score, String tier, int rank) {
		super();
		this.id = id;
		this.score = score;
		this.tier = tier;
		this.rank = rank;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "UserScore [id=" + id + ", score=" + score + ", tier=" + tier + ", rank=" + rank + "]";
	}
}
