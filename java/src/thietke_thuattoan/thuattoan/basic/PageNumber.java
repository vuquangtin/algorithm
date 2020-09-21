package thuattoan.basic;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class PageNumber {

	private int pageNumber = 0;
	private boolean current = false;
	public PageNumber(){
		
	}
	public PageNumber(int pageNumber, boolean current){
		this.pageNumber = pageNumber;
		this.current = current;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
}