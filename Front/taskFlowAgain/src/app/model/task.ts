import { Project } from "./project";

export interface Task {
  taskId: number;
  content: string;
  project: Project;
  status: string;
  dueDate: Date | null;
  createdAt: Date;
}
