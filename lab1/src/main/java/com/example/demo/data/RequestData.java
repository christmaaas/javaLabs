package com.example.demo.data;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@JacksonXmlRootElement(localName = "api")
public class RequestData {
    //@JacksonXmlProperty(localName = "query")
    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public static class Query {
        //@JacksonXmlProperty(localName = "pages")
        private Pages pages;

        public Pages getPages() {
            return pages;
        }

        public void setPages(Pages pages) {
            this.pages = pages;
        }
    }

    public static class Pages {
        //@JacksonXmlProperty(localName = "page")
        private Page page;

        public Page getPage() {
            return page;
        }

        public void setPage(Page page) {
            this.page = page;
        }
    }

    public static class Page {
        //@JacksonXmlProperty(localName = "_idx")
        private String idx;
        //@JacksonXmlProperty(localName = "pageid")
        private String pageid;
        //@JacksonXmlProperty(localName = "ns")
        private String ns;
        //@JacksonXmlProperty(localName = "title")
        private String title;
        //@JacksonXmlProperty(localName = "index")
        private String index;
        //@JacksonXmlProperty(localName = "extract")
        private String extract;

        public String getIdx() {
            return idx;
        }

        public void setIdx(String idx) {
            this.idx = idx;
        }

        public String getPageid() {
            return pageid;
        }

        public void setPageid(String pageid) {
            this.pageid = pageid;
        }

        public String getNs() {
            return ns;
        }

        public void setNs(String ns) {
            this.ns = ns;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getExtract() {
            return extract;
        }

        public void setExtract(String extract) {
            this.extract = extract;
        }
    }
}

