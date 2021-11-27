#####################################
##            VARIABLES            ##
#####################################



#####################################
##           QUICK START           ##
#####################################

dev: ## Run app in dev mode
	@./mvnw spring-boot:run -Pdev

test: ## Run app tests
	@./mvnw clean verify

start: ## Start local integration environment
	@docker compose up -d

destroy: ## Destroy local integration environment
	@docker compose down

int-ddl: ## Start app with int profile with ddl hibernate
	@./mvnw spring-boot:run -Pint,dev

int: ## Start app with int profile
	@./mvnw spring-boot:run -Pint

#####################################
##            BUILD APP            ##
#####################################

build: ## Build app
	@./mvnw spring-boot:build-image

#####################################
##             VERSION             ##
#####################################

get-version: ## Get app version
	@echo $$(xmllint --xpath '/*[local-name()="project"]/*[local-name()="version"]/text()' pom.xml)

update-version: ## Update app version
	@./mvnw --batch-mode release:update-versions -DautoVersionSubmodules=true -DdevelopmentVersion=$(VERSION)-SNAPSHOT
	@./mvnw --batch-mode versions:set -DremoveSnapshot -DprocessAllModules

.PHONY: help
help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.DEFAULT_GOAL := help
