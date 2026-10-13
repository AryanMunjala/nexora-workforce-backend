# Railway deployment — backend repository

1. Create or select a Railway project and add a MySQL service.
2. Add a service from `AryanMunjala/nexora-workforce-backend`, branch `main`. The Dockerfile is at the repository root.
3. Configure `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` using Railway MySQL reference variables. URL shape: `jdbc:mysql://HOST:PORT/DATABASE?useSSL=true&serverTimezone=UTC`.
4. Set `FRONTEND_ORIGIN` to the deployed frontend's HTTPS origin. Railway provides `PORT` automatically.
5. Deploy and verify the backend public URL plus `/api/health`.
6. Test employee creation, listing/search, update, and deletion.

Never commit real secrets. This repository contains only the backend service; the frontend is maintained in the separate frontend repository.
