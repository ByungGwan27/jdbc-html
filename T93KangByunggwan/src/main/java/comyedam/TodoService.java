package comyedam;

import java.util.List;

public interface TodoService {
	public List<ToDoVO> readTodo();
	
	public boolean createTodo(String title);
	
	public boolean updateTodoY(int todoN);
	
	public boolean updateTodoN(int todoN);
	
	public boolean deleteToto(int todoN);
}
