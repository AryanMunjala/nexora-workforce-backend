# Repository split and file coverage

The original full-stack repository is preserved at https://github.com/AryanMunjala/nexora-workforce.

## Backend files in this repository
All backend application files from the original `backend/` directory are at the root of this repository: Java source, resources, tests, Maven configuration, environment example, ignore rules, Railway configuration, Dockerfile, and Docker ignore file.

## Shared/root assets and where they went
- Root README information: summarized in this repository's README and project report.
- Root GitHub Actions workflow: separated into frontend and backend CI workflows in their respective repositories.
- Root `.env.example`: its database variables are represented in the backend environment example; local full-stack Compose secrets remain documented with the original monorepo.
- Root `.gitignore`: each standalone repository has its own ignore rules.
- Project report, Postman testing guide, importable Postman collection, deployment checklist, and Railway deployment notes are included in this repository in backend-specific form.
- `compose.yaml` is a full-stack integration file whose original build contexts point to both `frontend/` and `backend/`; it remains in the preserved monorepo rather than being copied unchanged into this standalone repository.

## Frontend
The React/Vite implementation is in https://github.com/AryanMunjala/nexora-workforce-frontend.

No files have been deleted from the original monorepo. The standalone repositories contain the appropriate application code and supporting files for presenting each layer separately.
