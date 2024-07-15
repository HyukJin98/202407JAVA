package dp2;

import java.util.Vector;

public class Student {
	private Vector<Transcript> transcript;
	private String name;
	public Student(String name) {
		super();
		this.transcript = new Vector<Transcript>();;
		this.name = name;
	}
	public void addTranscript(Transcript t1) {
		transcript.add(t1);
		
	}
	
	public void deleteTranscript(Transcript t1) {
		if(transcript.contains(t1)) {
			transcript.remove(t1);
		}
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
