import org.eclipse.jgit.lib.FileMode;
					changeBuilder.mode = FileMode.MISSING;
					changeBuilder.mode = FileMode.fromBits(Integer.parseInt(line.substring("deleted file mode ".length()), 8));
					changeBuilder.mode = FileMode.fromBits(Integer.parseInt(line.substring("new file mode ".length()), 8));
						changeBuilder.mode = FileMode.fromBits(Integer.parseInt(StringUtils.substringAfterLast(line, " "), 8));
		}, errorLogger).checkReturnCode();
		private FileMode mode;
			return new FileChangeWithDiffs(action, oldPath, newPath, mode, binary, 