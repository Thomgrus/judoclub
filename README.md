# judoclub

![build](https://github.com/Thomgrus/judoclub/actions/workflows/build.yml/badge.svg) ![build](https://github.com/Thomgrus/judoclub/actions/workflows/codeql-analysis.yml/badge.svg)

Judoclub application

[![Commitizen friendly](https://img.shields.io/badge/commitizen-friendly-brightgreen.svg)](http://commitizen.github.io/cz-cli/) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

The code is located in `server` directory.

To display available command: `make` or `make help`

## DEV

This mode use:
* h2 mem database
* flyway migration disabled
* hdm2ddl enabled

It use maven `dev` profile:
* set spring `dev` profile
* disable test and coverage

Run the app with:

```shell
make dev
```

## INT

This mode use:
* postgresql local database
* flyway migration enabled
* hdm2ddl disabled

Run it with:

```shell
make int
```

## TEST

Run test with:

```shell
make test
```

## UPDATE

Update project version with:

```shell
make update-version VERSION=X.Y.Z
```

You can get current project version with `make get-version`

## CONTRIBUTE

This project use [Angular Commit Message Conventions](https://github.com/angular/angular/blob/master/CONTRIBUTING.md#-commit-message-format) in order to generate nice changelog and increase maintenability and lisibility.

In local environment, you can use git hooks configured for developer.

To enable this tools, `node` is required. You can follow this step to use it:

```
npm install
npm run prepare
```

And that's all !

You can now use the standard `git commit` to interact with a prompt to build your conventional commits.

### Tools used

* [husky](https://github.com/typicode/husky)
* [commitizen](https://github.com/commitizen/cz-cli)

