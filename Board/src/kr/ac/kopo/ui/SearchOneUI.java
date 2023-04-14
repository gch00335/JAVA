package kr.ac.kopo.ui;

public class SearchOneUI  extends BaseUI {
 
	@Override
	public void execute() throws Exception {
		int no = scanInt("조회할 글번호를 입력하세요");
		
		System.out.println("==========================");
		System.out.println(" 번      호 :" + no);
		System.out.println(" 제      목 : ");
		System.out.println(" 작   성  자 : ");
		System.out.println(" 등   록  일 : ");
		System.out.println("==========================");
	}
}
