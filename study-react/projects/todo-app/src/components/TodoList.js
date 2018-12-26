import React from 'react';
import { connect } from 'react-redux';
import Todo from './Todo';
import { getTodoByVisibilityFilter } from "../redux/selectors";
import { VISIBILITY_FILTERS } from '../constants'

const TodoList = ({todos}) => (
    <ul className="todo-list">
        {todos && todos.length
            ? todos.map((todo, index) => {
                return <Todo key={`todo-${todo.id}`} todo={todo} />
            })
            : "No todos, yay!"
        }
    </ul>
)

const mapStateToProps = state => {
    const { visibilityFilter } = state;
    const todos = getTodoByVisibilityFilter(state, visibilityFilter);
    return { todos }
}

export default connect(mapStateToProps)(TodoList);