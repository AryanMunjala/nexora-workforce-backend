# Deployment checklist

- [ ] Deploy the Spring Boot backend to a Java-compatible host.
- [ ] Provision MySQL and configure DB_URL, DB_USERNAME, and DB_PASSWORD as environment variables.
- [ ] Set FRONTEND_ORIGIN to the deployed frontend origin.
- [ ] Confirm the hosting platform supplies PORT or configure the app's port appropriately.
- [ ] Verify the backend public URL and `/api/health`.
- [ ] Test employee create/list/update/delete against the deployed API.
- [ ] Never commit credentials or `.env` files.

Only mark items complete after verifying them in the target environment.
