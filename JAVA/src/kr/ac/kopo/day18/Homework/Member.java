package kr.ac.kopo.day18.Homework;

public class Member {

	

private String id ;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((p == null) ? 0 : p.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Member other = (Member) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (p == null) {
		if (other.p != null)
			return false;
	} else if (!p.equals(other.p))
		return false;
	return true;
}
private String p;




public Member(String id, String p) {
	this.id = id;
	this.p = p;



}
public String getID() {
	return this.id;
}
public String getP() {
	return this.p;
}
public void Setp (String p) {
	this.p = p ;
}

}

