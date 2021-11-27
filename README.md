# judoclub
Judoclub application

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
