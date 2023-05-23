package comyedam;

import java.util.List;

public interface TodoMapper {
	public List<ToDoVO> readTodo();
	
	public int createTodo(String title);
	
	public int updateTodoY(int todoN);
	
	public int updateTodoN(int todoN);
	
	public int deleteToto(int todoN);
}
