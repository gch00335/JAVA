package kr.ac.kopo.day18.Homework;
/*
 *  alt +shift+ s누른 후 c선택 : 디폴트 생성자
 *  alt +shift+ s누른 후 o선택 : 매개변수를 가진 생성자
 *  alt +shift+ s누른 후 r선택 : get,set 생성자
 *  alt +shift+ s누른 후 S선택 : toString() 오버라이딩 생성자
 *  alt +shift+ s누른 후 v선택 : 오버라이드에 대한 메소드 생성

 */
public class Member_Teacher {



		private String id;
		private String password;
		
		
		public Member_Teacher() {
			super();		
		}


		public Member_Teacher(String id, String password) {
			super();
			this.id = id;
			this.password = password;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getPassword() {
			return password;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			Member_Teacher other = (Member_Teacher) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}


		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Member [id=" + id + ", password=" + password + "]";
		}
		
		
	}






