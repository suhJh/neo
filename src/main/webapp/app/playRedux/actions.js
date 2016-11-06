
export const CRUD = {
  INSERT: 'INSERT',
  DELETE: 'DELETE',
  UPDATE: 'UPDATE',
  SELECT: 'SELECT',
};

export const insertPost = post => ({ type: CRUD.INSERT, post });
export const updatePost = post => ({ type: CRUD.UPDATE, post });
export const deletePost = post => ({ type: CRUD.DELETE, post });
export const selectPost = post => ({ type: CRUD.SELECT, post });
