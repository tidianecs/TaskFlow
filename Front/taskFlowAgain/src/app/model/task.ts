export interface Task {
  taskId: number;
  content: string;
  status: string;
  dueDate: Date | null;
  createdAt: Date;
}
