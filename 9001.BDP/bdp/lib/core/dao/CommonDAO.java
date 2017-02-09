package lib.core.dao;

public interface CommonDAO {

	public Object insert(Object obj);

	public void select(String id);

	public void update(Object obj);

	public void delete(Object obj);

	public void search(String param);
}
