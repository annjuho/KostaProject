package erp.acc.basic.persistence;

import java.util.List;

import erp.acc.basic.domain.Statements;

public interface StatementDAO {

	List<Statements> StatementAllList() throws Exception;

	List<Statements> StatementAllSalesList() throws Exception;
	/*List<Statements> StatementPromissorySalesList() throws Exception;*/

	List<Statements> StatementAllPurchaseList() throws Exception;
	/*List<Statements> StatementPromissoryPurchaseList() throws Exception;*/

}
