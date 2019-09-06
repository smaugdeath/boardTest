package kr.or.ddit.common.model;

public class Page {
   private int page;
   private int pagesize;
   
   public Page() {
	   
   }

   public Page(int page, int pagesize) {
	   this.page = page;
	   this.pagesize = pagesize;
   }

   public int getPage() {
      return page;
   }

   public void setPage(int page) {
      this.page = page;
   }

   public int getSize() {
      return pagesize;
   }

   public void setSize(int size) {
      this.pagesize = size;
   }

   @Override
   public String toString() {
      return "Page [page=" + page + ", size=" + pagesize + "]";
   }
}