package erp.my.mytext.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class MyDeptTextPageMaker {

  private int totalCount;
  private int startPage;
  private int endPage;
  private boolean prev;
  private boolean next;

  private int displayPageNum = 5;

  private MyDeptTextCriteria deptCri;

  public void setDeptCri(MyDeptTextCriteria deptCri) {
    this.deptCri = deptCri;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;

    calcData();
  }

  private void calcData() {

    endPage = (int) (Math.ceil(deptCri.getDeptPage() / (double) displayPageNum) * displayPageNum);

    startPage = (endPage - displayPageNum) + 1;

    int tempEndPage = (int) (Math.ceil(totalCount / (double) deptCri.getDeptPerPageNum()));

    if (endPage > tempEndPage) {
      endPage = tempEndPage;
    }

    prev = startPage == 1 ? false : true;

    next = endPage * deptCri.getDeptPerPageNum() >= totalCount ? false : true;

  }

  public int getTotalCount() {
    return totalCount;
  }

  public int getStartPage() {
    return startPage;
  }

  public int getEndPage() {
    return endPage;
  }

  public boolean isPrev() {
    return prev;
  }

  public boolean isNext() {
    return next;
  }

  public int getDisplayPageNum() {
    return displayPageNum;
  }

  public MyDeptTextCriteria getDeptCri() {
    return deptCri;
  }

  public String makeQuery(int deptPage) {

    UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("deptPage", deptPage)
        .queryParam("deptPerPageNum", deptCri.getDeptPerPageNum()).build();

    return uriComponents.toUriString();
  }
  
}
