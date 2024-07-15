package dp2;

import java.util.Vector;

public class Course {
	
	private Vector<Transcript> transcript;
	private String name;
	
	public void addTranscript(Transcript t1) {
		transcript.add(t1);
		
	}
	
	public void deleteTranscript(Transcript t1) {
		if(transcript.contains(t1)) {
			transcript.remove(t1);
		}
	}
	
	
	@Override
	public String toString() {
		return "Course [transcript=" + transcript + ", name=" + name + "]";
	}
	public Course(Vector<Transcript> transcript, String name) {
		super();
		this.transcript = transcript;
		this.name = name;
	}
	public Vector<Transcript> getTranscript() {
		return transcript;
	}
	public void setTranscript(Vector<Transcript> transcript) {
		this.transcript = transcript;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
