# Deployment for server and client to OpenShift

## General info

This repository contains tags of the format:
- `server-<major>.<minor>.<patch>`
- `client-<major>.<minor>.<patch>`

Corresponding image tags are built upon these tags and pushed to quay repositories:
- https://quay.io/repository/rh-ee-akridl/person-server
- https://quay.io/repository/rh-ee-akridl/person-client

---

## Structure

### deployments/openshift
- plain deployments for OpenShift
- better to understand this before diving into `deployments/helm`

### deployments/helm
- deployments using Helm templating
- better to look at this only when understanding what's done in `deployments/openshift`
