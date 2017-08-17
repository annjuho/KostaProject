package erp.my.mytext.domain;

public class MyDeptTextCriteria {

  private int deptPage=1;
  private int deptPerPageNum=2;

  public MyDeptTextCriteria() {
    this.deptPage = 1;
    this.deptPerPageNum = 3;
  }

  public void setDeptPage(int page) {

    if (page <= 0) {
      this.deptPage = 1;
      return;
    }

    this.deptPage = page;
  }

  public void setDeptPerPageNum(int perPageNum) {

    if (perPageNum <= 0 || perPageNum > 100) {
      this.deptPerPageNum = 3;
      return;
    }

    this.deptPerPageNum = perPageNum;
  }

  public int getDeptPage() {
    return deptPage;
  }

  // method for MyBatis SQL Mapper -
  public int getPageStart() { // 시작 데이터 번호 산출

    return (this.deptPage - 1) * deptPerPageNum;
  }

  // method for MyBatis SQL Mapper
  public int getDeptPerPageNum() {

    return this.deptPerPageNum;
  }

  @Override
  public String toString() {
    return "Criteria [deptPage=" + deptPage + ", "
        + "deptPerPageNum=" + deptPerPageNum + "]";
  }
}
