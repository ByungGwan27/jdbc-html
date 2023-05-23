package comyedam;

import java.util.List;

public class TodoServiceImpl implements TodoService{
	TodoMapper mapper = DataSource.getInstance()
			.openSession(true).getMapper(TodoMapper.class);

	@Override
	public List<ToDoVO> readTodo() {
		return mapper.readTodo();
	}

	@Override
	public boolean createTodo(String title) {
		return mapper.createTodo(title) == 1;
	}

	@Override
	public boolean updateTodoY(int todoN) {
		return mapper.updateTodoY(todoN) == 1;
	}

	@Override
	public boolean updateTodoN(int todoN) {
		return mapper.updateTodoN(todoN) == 1;
	}

	@Override
	public boolean deleteToto(int todoN) {
		return mapper.deleteToto(todoN) == 1;
	}

}
