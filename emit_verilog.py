import os

from argparse import ArgumentParser


def main() -> None:
    parser: ArgumentParser = ArgumentParser()
    parser.add_argument("--pkg", type=str, help="Package of entry point object")
    parser.add_argument("--obj", type=str, help="Entry point object")
    parser.add_argument("--dest", type=str, help="Destination folder name")
    args = parser.parse_args()

    sbt_cmd: str = f'sbt "runMain {args.pkg}.{args.obj}"'

    os.system(sbt_cmd)
    os.system(f'mv ./{args.obj}.sv ./rtl/{args.dest}/{args.dest}{args.obj[-1]}.v')

    return


if __name__ == '__main__':
    main()
