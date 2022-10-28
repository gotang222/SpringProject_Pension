package pack.spring.pension.bbs;

public class PageVO {

	private int numPerPage = 10; // 페이지당 출력하는 데이터 수(=게시글 숫자)
	private int pagePerBlock = 5; // 블럭당 표시되는 페이지 수의 개수
	private int totalRecord; // 전체 데이터 수(DB에 저장된 row 개수)
	private int totalPage; // 전체 페이지 수
	private int totalBlock; // 전체 블록수
	private int nowPage; // 현재 (사용자가 보고 있는) 페이지 번호
	private int nowBlock; // 현재 (사용자가 보고 있는) 블럭
	private int start; // DB에서 데이터를 불러올 때 시작하는 인덱스 번호
	private int end; // 시작하는 인덱스 번호부터 반환하는(=출력하는) 데이터 개수
	private int pageStart;
	private int pageEnd;

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		this.totalPage = (int) Math.ceil((double) this.totalRecord / this.numPerPage);
		this.totalBlock = (int) Math.ceil((double) this.totalPage / this.pagePerBlock);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		this.nowBlock = (int) Math.ceil((double) this.nowPage / this.pagePerBlock);
		this.start = (this.nowPage * this.numPerPage) - this.numPerPage;
		this.end = this.numPerPage;
		this.pageStart = (this.nowBlock - 1 ) * this.pagePerBlock + 1;
		this.pageEnd = (this.nowBlock < this.totalBlock) ? this.pageStart + this.pagePerBlock - 1 :  this.totalPage;
	}

	public int getNowBlock() {
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	
	

}
