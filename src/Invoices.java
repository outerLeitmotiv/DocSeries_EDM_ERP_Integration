import javax.tools.FileObject;
import java.util.List;
import java.util.Map;

/**
 * @author outerLeitmotiv
 * <a href="https://github.com/outerLeitmotiv">...</a>
 * {@code @Date} 30.03.23
 */
public class Invoices {

    //simple list of maps, a map consists of a POJO as key and a binary as value
    private List<Map<String, Object>> invoiceList;

    public List<Map<String, Object>> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Map<String, Object>> invoiceList) {
        this.invoiceList = invoiceList;
    }

}
