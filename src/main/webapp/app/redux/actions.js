
export const chatActions = {
  newChat: 'newChat',
  prevList: 'prevList',
};

export const newChat = chat => ({ type: chatActions.newChat, chat });
export const prevList = chats => ({ type: chatActions.prevList, chats });
