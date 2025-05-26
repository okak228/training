export interface Entity {
  id: string;
  name: string;
  description: string;
  date: string;
  dateTime: string;
  offsetDateTime: string;
  userId: string;
}

export interface EntityPageRs {
  items: Entity[];
  total: number;
}
