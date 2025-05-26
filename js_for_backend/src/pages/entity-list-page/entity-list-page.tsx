import { Button, Pagination, TextField } from '@mui/material';
import {
  deleteEntity,
  Entity,
  EntityCard,
  EntityPageRs,
  getEntities,
} from 'entities/entity';
import React, { useEffect, useState } from 'react';
import { Link, useSearchParams } from 'react-router-dom';

import styles from './styles.module.css';

export const EntityListPage = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const [entities, setEntities] = useState<EntityPageRs>({
    items: [],
    total: 0,
  });
  const page = Number(searchParams.get('page') ?? '1');

  const fetchEntities = async () => {
    const entities = await getEntities({
      limit: '5',
      page: String(page),
      name: searchParams.get('name') ?? '',
    });
    setEntities(entities);
  };

  useEffect(() => {
    fetchEntities();
  }, [searchParams]);

  const handleDelete = async (entity: Entity) => {
    await deleteEntity(entity.id);
    fetchEntities();
  };

  const handlePaginationChange = (_: unknown, count: number) => {
    searchParams.set('page', String(count));
    setSearchParams(searchParams);
  };

  const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    searchParams.set('name', event.target.value);
    searchParams.set('page', '1');
    setSearchParams(searchParams);
  };

  return (
    <div className={styles.page}>
      <div>
        <TextField size="small" onChange={handleSearchChange} />
        <Link to="/entity/new">
          <Button variant="contained">Создать</Button>
        </Link>
      </div>
      <div className={styles.list}>
        {entities.items.map((entity) => (
          <EntityCard entity={entity} onDelete={handleDelete} key={entity.id} />
        ))}
      </div>
      <Pagination
        page={page}
        count={entities.total}
        onChange={handlePaginationChange}
      />
    </div>
  );
};
