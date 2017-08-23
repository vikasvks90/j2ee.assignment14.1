package assignment14.session1.dao;

import java.util.List;

public interface PersonDao {
    List<?> selectAll();
    void insert(String Name);
}
